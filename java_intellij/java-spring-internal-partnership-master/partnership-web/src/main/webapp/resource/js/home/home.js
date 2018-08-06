
           /* var slideIndex = 1;
            var slideImg= document.getElementsByClassName("slide");
            showSlide(slideIndex,slideImg);
            function plusImg(n){
                showSlide(slideIndex += n,slideImg);
            }
            setInterval(function(){
                plusImg(1);
            },5000);
            function showSlide(n,slides) {
                  var i;
                  if (n > slides.length) {slideIndex = 1}    
                  if (n < 1) {slideIndex = slides.length} ;
                  for (i = 0; i < slides.length; i++) {
                      slides[i].classList.remove("slide-active");  
                  } 
                  slides[slideIndex-1].classList.add("slide-active");
            } 
            
            *$(function(){
            *	$
            *})
            */

           /*------------------Slide show ------------------------------------
			$(document).ready(function(){
				function slideShow(){
					var i=0;
					var slide= $('.slide');
					for(i ; i < slide.length() ; i++){
						
					}
				}
				setInterval("slideShow()",4000);
			}) */

			 $(".bacground-search > .slide:gt(0)").hide();
					setInterval(function() { 
					  $('.bacground-search > .slide:first')
					    .fadeOut(20)
					    .next()
					    .fadeIn(10)
					    .end()
					    .appendTo('.bacground-search');
					},  5000);

			/*---------------------- SCROLL FUNCTION --------------------------*/
			$(window).scroll(function(){
				if($(window).scrollTop() > $('.search').outerHeight() ){
					$('.search').addClass('scrollActive');
					$('.search > .logo-search').show();
					$('.search > .form-search').css('width','90%');
					
				}
				else{
					$('.search').removeClass('scrollActive');
					$('.search > .logo-search').hide();
					$('.search > .form-search').css('width','100%');
				}
			});	
			



			
			
			
            function toPage( a ){

	                switch(a){
	                    case 0:
	                        effect( a  )
	                        break;
	                    case 1:
	                        effect( a  )
	                        break;
	                    case 2:
	                        effect( a  )
	                        break;
                }
            }
           
            function effect( a , link ){
                //document.getElementById("iframe-suggest").src = link;
                var x = document.getElementsByClassName("suggest");
                for (var i =0; i<3 ; i++){
                 x[i].classList.remove("active");   
                }                
                x[a].classList.add("active");
                
            }
            
    