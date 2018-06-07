<body>
<div id="fb-root"></div>
<script>

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8&appId=800058586802922";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>    
        <div class="container view-searchpro5">
            <section id="section1" class="container">
                <div class="col-sm-3 no-padding-horizon image-searchdetails">
                            <img src="${user.profile.getImage() }" class="business-item--cover__large-searchdetails"> 
                    </div>  
                <div class="col-sm-5">
                    <div class="button-group--recommendation pull-right"><span class="recommend-button--square--mini"><a href="#" class="hvr-wobble-vertical"><img src="E:\partnership-documents/like-square.png" onmouseover="bigImg(this)" onmouseout="normalImg(this)"></a></span><span class="unrecommend-button--square--mini"><a href="#" class="hvr-wobble-horizontal"><img src="E:\partnership-documents/dislike-square.png" onmouseover="bigImg(this)" onmouseout="normalImg(this)"></a></span></div>
                    <header>
                        <h1>${user.profile.getFirstName() } ${user.profile.getLastName() }</h1>
                    </header>
                            
                    <h3 class="container">
                            <a href="#"><i class="fa fa-star" style="font-size:30px;color:#ffcc00;"></i></a>
                            <a href="#"><i class="fa fa-star" style="font-size:30px;color:#ffcc00;"></i></a>
                            <a href="#"><i class="fa fa-star" style="font-size:30px;color:#ffcc00;"></i></a>
                            <a href="#"><i class="fa fa-star-half-full" style="font-size:30px;color:#ffcc00;"></i></a>
                    </h3>       
                        <div class="container business-item--location clear"><i class="fa fa-gavel"></i><span>Business 1 Business 2</span></div>
                    <div class="business-item--location clear"><i class="fa fa-map-marker"></i><span>Việt Nam-Đà Nẵng-Sơn Trà</span></div>
                    <h4 class="container">
                        <div class="email-details">
                            <a href="mailto:thelittleitaly@gmail.com" class="business-info-link"><i class="fa fa-envelope"> </i><span>Email</span></a>
                        </div>
                        <div class="fb-details">
                            <a href="https://www.facebook.com/TheLittleitalyAnnecy/timeline" target="_blank" class="business-info-link"><i class="fa fa-facebook-square"> </i><span>Facebook</span></a>

                        </div>
                    </h4>
                    <h4 class="container contact-details">
                        <a href="tel:+33450529278" class="btn btn-primary btn-outline btn-business-cta" ><i class="fa fa-phone" ></i><span>&nbsp; +33450529278                          </span></a>
                        <button id="business-contact" class="btn btn-outline btn-primary btn-business-cta"><i class="fa fa-envelope-o fa-fw i-message"></i><span>&nbsp; Write a message             </span></button>
                    </h4>
                        
                </div>
                
                <div class="col-sm-4">
                    <div id="map" style="width:100%;height:350px;background:gray"></div>
                    <script>
                    function myMap() {
                        var mapOptions = {
                            center: new google.maps.LatLng(51.5, -0.12),
                            zoom: 10,
                            mapTypeId: google.maps.MapTypeId.HYBRID
                        }
                    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
                    }
                    </script>
                    <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
                </div>
             </section>       

            
            <hr class="container">
            <footer  class="container">
                    <section class="container">
                        <label class="container"for="comment">Discription</label>
                        <div class="well well-lg">
                            <p>Hi I'm Developer Java and Designer 3D</p>
                            <p>Thanks you.</p>
                        </div>
                    </section>  
            </footer>
            <hr class="container">
            <footer >
                <section class="container">
                    <h4 id="photo-gallery-products" class="business-item--subtitle business-item--photo-gallery"><i class="fa fa-picture-o"></i>&nbsp;Products</h4>
                    <ul data-options="100" class="business-item--photo-gallery-list">
                        <li>
                            <a data-fancybox-group="gallery" href="https://s3.amazonaws.com/lrc-media/business-gallery/b9809606188f5e75e429272d6e56dc501464596081280/large.jpg" class="fancybox"><img src="https://s3.amazonaws.com/lrc-media/business-gallery/b9809606188f5e75e429272d6e56dc501464596081280/small.jpg" alt=""></a>
                        </li>
                        <li>
                            <a data-fancybox-group="gallery" href="https://s3.amazonaws.com/lrc-media/business-gallery/3e843b5deca0f3c935fa183c1c0e3ab31464596167956/large.jpg" class="fancybox"><img src="https://s3.amazonaws.com/lrc-media/business-gallery/3e843b5deca0f3c935fa183c1c0e3ab31464596167956/small.jpg" alt=""></a>
                        </li>
                        <li>
                            <a data-fancybox-group="gallery" href="https://s3.amazonaws.com/lrc-media/business-gallery/1933028057698a7f8967f602de137b361464597222941/large.jpg" class="fancybox"><img src="https://s3.amazonaws.com/lrc-media/business-gallery/1933028057698a7f8967f602de137b361464597222941/small.jpg" alt=""></a>
                        </li>
                        <li>
                            <a data-fancybox-group="gallery" href="https://s3.amazonaws.com/lrc-media/business-gallery/00b18830ca7cf3dd737a643dd0d2aecd1464597223060/large.jpg" class="fancybox"><img src="https://s3.amazonaws.com/lrc-media/business-gallery/00b18830ca7cf3dd737a643dd0d2aecd1464597223060/small.jpg" alt=""></a>
                        </li>
                        <li>
                            <a data-fancybox-group="gallery" href="https://s3.amazonaws.com/lrc-media/business-gallery/1379e8d46a73407f062f20dc73c702181473838907217/large.jpg" class="fancybox"><img src="https://s3.amazonaws.com/lrc-media/business-gallery/1379e8d46a73407f062f20dc73c702181473838907217/small.jpg" alt=""></a>
                        </li>
                    </ul>
                </section>
            </footer>
        </div>
    </body>
