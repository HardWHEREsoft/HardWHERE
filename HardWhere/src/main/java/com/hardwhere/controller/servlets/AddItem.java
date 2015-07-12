package com.hardwhere.controller.servlets;

/**
 * Created by menaka on 7/11/15.
 */
import com.hardwhere.controller.javaclasses.InsertIntoDB;
import com.hardwhere.controller.javaclasses.MongoDBConnection;
import com.hardwhere.model.Item_POJO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.print.attribute.standard.PrinterState;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by menaka on 7/9/15.
 */
public class AddItem extends HttpServlet{

    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        Item_POJO item = new Item_POJO();
        item.setItem_ID(System.nanoTime());
        item.setUser(request.getRemoteUser());
        item.setItem_Name(request.getParameter("item_Name"));
        item.setItem_Description(request.getParameter("item_description"));
        item.setItem_Price(request.getParameter("item_price"));
        item.setItem_Image(request.getParameter("item_image"));
        item.setItem_Type(request.getParameter("item_Type"));
//        item.setUser_id(request.getParameter(""));

        InsertIntoDB iidb = new InsertIntoDB(item);
        System.out.println(iidb.toDBObject());
        MongoDBConnection mdbc = new MongoDBConnection();
        mdbc.createConnection();
//        System.out.println(mdbc.show());
        fileUplod(request);
        try {
            RequestDispatcher rd = request.getRequestDispatcher("additem.jsp");
            String message = "Item added successfully";
            request.setAttribute("Result", message);
//            rd.include(request, response);
            rd.forward(request, response);
//            PrintWriter out = response.getWriter();
//            out.print(mdbc.show());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


        mdbc.show();
    }


    public void fileUplod(HttpServletRequest req){


        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + DATA_DIRECTORY;

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    // saves the file to upload directory
                    item.write(uploadedFile);
                }
            }


        } catch (FileUploadException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}