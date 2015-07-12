function alertMe(){
    $(".show-hide").slideToggle();
};

$(function() {
    $(document).on('click', "#categories h4", function(e){
        $('#categories').find('.row').slideUp();
        $(this).closest('a').next('div').slideDown();
        e.stopPropagation();
    })
});

$(document).ready(function(){
    $("#search").bind('keyup', function(){
        var jsn = new Object();
        jsn = {"items" : [{"name":"cement"} , {"name" : "sand"}] };
        console.log(JSON.parse(jsn));
        var typed = $(this).val();
        console.log(typed);
    })
});


