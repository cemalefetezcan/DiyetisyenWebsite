
$(function(){
    $("#gecis1").click(function(){
            $('#orta_alan').css({'height' : '400px'});
            $('#orta_alan').css({'background-color' : '#f7cac9'});
            //$('#orta_alan').toggleClass();
            
            //$('#randevu_form').css({'visibility' : 'visible'});
            //$('#gecis1').css({'visibility' : 'hidden'});
            //$('#gecis2').css({'visibility' : 'visible'});               
        return false;
    });
    $("#gecis1").mouseup(function() {
        var delayInMilliseconds = 500; //1 second
            setTimeout(function() {
            //your code to be executed after 1 second
            //window.scrollTo(0, 700); 
            if($(window).width()>=993){
                $("html, body").animate({ scrollTop:660}, 3000);     
            }
            else if($(window).width()<993 && $(window).width()>=601){
                $("html, body").animate({ scrollTop:710}, 3000);     
            }
            else if($(window).width()<601){
                $("html, body").animate({ scrollTop:1280}, 3000);     
            }
            
            $('#randevu_form').css({'visibility' : 'visible'});
            $("#doktor_adi").text("EDA GÜREL");
            document.getElementById("doktor_adi1").setAttribute('value','EDA GÜREL');
            $('#orta_alan').css({'display' : 'inline'});
            }, delayInMilliseconds);
       
    });

    

    $("#gecis2").click(function(){
            $('#orta_alan').css({'height' : '400px'});
            $('#orta_alan').css({'background-color' : '#80ced6'});
            //$('#randevu_form').css({'visibility' : 'visible'});
            //$('#gecis1').css({'visibility' : 'hidden'});
            //$('#gecis2').css({'visibility' : 'visible'});                
        return false;
    });
    $("#gecis2").mouseup(function() {
        var delayInMilliseconds = 500; //1 second
            setTimeout(function() {
            //your code to be executed after 1 second
            //window.scrollTo(0, 700); 
            if($(window).width()>=993){
                $("html, body").animate({ scrollTop:660}, 3000);     
            }
            else if($(window).width()<993 && $(window).width()>=601){
                $("html, body").animate({ scrollTop:710}, 3000);     
            }
            else if($(window).width()<601){
                $("html, body").animate({ scrollTop:1280}, 3000);     
            }
            $('#randevu_form').css({'visibility' : 'visible'});
            $("#doktor_adi").text("AHMET YERLİ");
            document.getElementById("doktor_adi1").setAttribute('value','AHMET YERLİ');
            $('#orta_alan').css({'display' : 'inline'});
            }, delayInMilliseconds);
       
    });
}); 
