<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-13
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Slider -->
<section id="slider" class=" mt-4 py-5 bg-main">


    <div id="carousel" class="carousel slide relative w-75 mx-auto  border-custom bottom-shadow" data-ride="carousel">
        <div class="slider-caption w-50 bg-overlay">
            <blockquote class="blockquote text-center d-none d-md-block">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Temporibus pariatur neque</blockquote>
        </div>
        <ol class="carousel-indicators" style="margin-bottom: -40px">
            <li data-target="#carousel" data-slide-to="0" class="active"> </li>
            <li data-target="#carousel" data-slide-to="1"> </li>
            <li data-target="#carousel" data-slide-to="2"> </li>
            <li data-target="#carousel" data-slide-to="3"></li>
            <li data-target="#carousel" data-slide-to="4"> </li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block img-fluid" src="img/image_1.jpg" alt="First slide"/>
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="img/image_2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="img/image_3.jpg" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev justify-content-start" style="margin-left: -40px" href="#carousel" role="button" data-slide="prev">
            <i class="fa fa-chevron-circle-left fa-2x  "></i>

        </a>
        <a class="carousel-control-next justify-content-end" style="margin-right: -40px" href="#carousel" role="button" data-slide="next">
            <i class="fa fa-chevron-circle-right fa-2x"></i>

        </a>
    </div>
</section>
<!-- Last Project -->
<section id="lastProject" class=" bg-main pt-5">
    <div class="title ">
        <h3 class="text-title text-uppercase p-2 bg-main d-inline bottom-shadow ">Lasted Project</h3>
    </div>
    <div class="row mt-5">
        <div class="col-md-4 col-sm-6 parent">
            <div class="post bg-main ml-4 p-3 d-none d-sm-block wow fadeInRight">
                <h4 class="text-muted">The Modern Office</h4>
                <p class="lead text-white ">Lorem ipsum dolor sit amet consectetur adipisicing elit. Saepe ipsam fuga ut cum ab magnam dolore.</p>
            </div>
        </div>
        <div class="col-md-8 col-sm-6 text-center wow fadeInLeft">
            <img src="img/image_6.jpg"  alt="" class="img img-fluid mt-3 max-height border-custom bottom-shadow">
        </div>
    </div>
    <div class=" row mt-sm-5 mt-3 parent pb-5">

        <div class=" col-md-8 col-sm-6 text-center wow fadeInRight">
            <img src="img/image_7.jpg" alt="" class="img img-fluid mt-3 max-height border-custom bottom-shadow">
        </div>
        <div class="col-md-4 col-sm-6 ">
            <div class="post bg-main mr-4 p-3 d-none d-sm-block wow fadeInLeft">
                <h4 class="text-muted">The Fantastic Office</h4>
                <p class="lead text-white ">Lorem ipsum dolor sit amet consectetur adipisicing elit. Saepe ipsam fuga ut cum ab magnam dolore.</p>
            </div>
        </div>
    </div>
</section>
<!-- Mini Gallery -->
<section id="miniGallery" class=" bg-main pt-5">
    <div class="title text-right mb-5">
        <h3 class="text-title text-uppercase p-2 bg-main d-inline bottom-shadow">Mini Gallery</h3>
    </div>
    <div class="row no-gutters">
        <div class="col-sm-4 p-1 relative">
            <a href="img/g1.jpg" data-toggle="lightbox">
                <div class="zoomin"></div>
                <img src="img/g1.jpg" alt="" class="img-fluid">
            </a>
        </div>
        <div class="col-sm-4 p-1">
            <div class="zoomin"></div>
            <a href="img/g2.jpg" data-toggle="lightbox">
                <div class="zoomin"></div>
                <img src="img/g2.jpg" alt="" class="img-fluid">
            </a>
        </div>
        <div class="col-sm-4 p-1">
            <a href="img/g3.jpg" data-toggle="lightbox">
                <div class="zoomin"></div>
                <img src="img/g3.jpg" alt="" class="img-fluid">
            </a>
        </div>
    </div>
    <div class="row no-gutters">
        <div class="col-sm-4 p-1">
            <a href="img/g4.jpg" data-toggle="lightbox">
                <div class="zoomin"></div>
                <img src="img/g4.jpg" alt="" class="img-fluid">
            </a>
        </div>
        <div class="col-sm-4 p-1">
            <a href="img/g5.jpg" data-toggle="lightbox">
                <div class="zoomin"></div>
                <img src="img/g5.jpg" alt="" class="img-fluid">
            </a>
        </div>
        <div class="col-sm-4 p-1">

            <a href="img/g6.jpg" data-toggle="lightbox">
                <div class="zoomin"></div>
                <img src="img/g6.jpg" alt="" class="img-fluid">
            </a>
        </div>

    </div>
    <div class="text-center pt-5">
        <a href="#" class="btn btn-light btn-main btn-lg px-5 text-title ">View More</a>
    </div>
</section>
<!-- Subscribe -->
<section id="subscribe" class="bg-main py-5">
    <div class="title ">
        <h3 class="text-title text-uppercase p-2 bg-main d-inline bottom-shadow">Subscribe Us</h3>
    </div>
    <div class="row px-5">
        <div class="col">
            <div class="mt-5 py-3 bg-main text-center mx-auto wow bounceIn ">
                <h4 class="text-muted">Want To Build?</h4>
                <p class="lead text-white d-none d-sm-block">Lorem ipsum dolor sit amet consectetur adipisicing elit. Saepe ipsam fuga ut cum ab magnam dolore.</p>
                <form class="form-inline justify-content-center px-3">
                    <div class="input-group ">
                        <input type="email" placeholder="Email" class="form-control">
                        <span class="input-group-append">
                                    <input type="submit" value="SUMIT" class="btn btn-light btn-main">
                                </span>
                    </div>
                </form>
            </div>

        </div>

    </div>
</section>

