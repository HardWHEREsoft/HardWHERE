var tm = 800;

function selectType(){
    var t = $("#type option:selected").text();
    
    if(t == "Material"){
        selectTile();
        $("#form_add").find("tr").not("#tile_brands").show(tm);
        $("#name").text("Name of Material");
    }
    
    if(t == "Equipment"){
        $("#name").text("Name of Equipment");
        $("#mat_type, #tile_brands, #tile_brands").hide(tm);
        $("#form_add").find("tr").not("#mat_type, #tile_brands, #tile_brands").show(tm);
    }
    
    if(t == "Service"){
        $("#form_add").find("tr").hide(tm);        
        $("#name").text("Name of Service");
        $("#name_tr, #desc_tr, #submit_tr, #price_tr").show(tm);
    }
    
}

function selectTile(){
    var t = $("#type_mat option:selected").text();
    if(t != "Tiles"){
        $("#tile_brands").hide(tm);
    }else{
        $("#tile_brands").show(tm);
    }
}