 
 // Script to open and close sidenav
 function ok_open() {
    document.getElementById("mySidenav").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}

function ok_close() {
    document.getElementById("mySidenav").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}    

function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode != 46 && charCode > 31 
    && (charCode < 48 || charCode > 57))
    return false;
    return true;
}  


function isNumericKey(evt)
{
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode != 46 && charCode > 31 
    && (charCode < 48 || charCode > 57))
    return true;
    return false;
} 

function getDate(evt){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    today = mm + '/' + dd + '/' + yyyy;

    document.getElementById("date-input").value = today;    
}

function getTime(evt){
    var today = new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var dateTime = date+' '+time;

    document.getElementById("time-input").value = time;    
}

$(document).ready(function () {
    'use strict';
    var currentTime = new Date();
    var minDate = new Date(currentTime.getFullYear(), currentTime.getMonth(), 1);
    var maxDate =  new Date(currentTime.getFullYear(), currentTime.getMonth() + 1, 0);
    $.datetimepicker.setLocale('tr');
        $('#tarih').datetimepicker({
            format:'d.m.Y H:i',
            minDate: 0,                 
            maxDate: maxDate ,                
            dayOfWeekStart: 1,                  
            disabledWeekDays:[0, 6],                            
            allowTimes:['10:00', '11:00', '12:00','14:00', '15:00', '16:00', '17:00', '18:00']
        });        
    });