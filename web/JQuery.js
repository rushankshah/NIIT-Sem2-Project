$(document).ready(function(){
                $(".btn_header").hover(function(){
                    $(this).css({"color":"blue"});
                    $(this).css({"background-color":"white"});
                    $(this).css({"border-radius":"2px solid blue"});
                },
                function(){
                    $(this).css({"color":"white","background-color":"blue","border-radius":"none"});
                }
               );
           });