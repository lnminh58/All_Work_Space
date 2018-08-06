<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home Design</title>

    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />

    <link rel="stylesheet" href="css/style.css"/>


</head>

<body>

<div class="container">

    <!-- Header With Narbar -->
    <header class=" mt-4">

        <div class="parent py-2 bg-header">
            <div class="display-4 float-left text-white ml-5">
                <i class="fa fa-500px"></i> M-Design</div>
            <form class="form-inline float-right d-none d-md-block py-4">
                <div class="input-group input-group-sm mr-4">
                    <input class="form-control" type="text" placeholder="Search">
                    <span class="input-group-append">
                            <button class="btn btn-light btn-main" type="submit">Search</button>
                        </span>

                </div>
            </form>
        </div>
        <nav class="navbar navbar-expand-md navbar-dark bg-main p-0 ">
            <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarNav">
                <ul class="navbar-nav mx-auto ">
                    <li class="nav-item">
                        <a class="nav-link px-3 text-uppercase   text-white" href="#">Home </a>
                    </li>
                    <li class="nav-item  ">
                        <a class="nav-link  px-3  text-uppercase   text-white" href="#">About Us</a>
                    </li>
                    <li class="nav-item  dropdown  ">
                        <a class="nav-link px-3 dropdown-toggle  text-uppercase text-white" href="#" id="dropdownService" data-toggle="dropdown">Services</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item  text-white" href="#">Package 1</a>
                            <a class="dropdown-item  text-white " href="#">Package 2</a>
                            <a class="dropdown-item  text-white " href="#">Package 2</a>
                        </div>
                    </li>
                    <li class="nav-item  dropdown  ">
                        <a class="nav-link px-3 dropdown-toggle  text-uppercase text-white" href="#" id="dropdownService" data-toggle="dropdown">Projects</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item  text-white" href="#">Project 1</a>
                            <a class="dropdown-item  text-white " href="#">Project 2</a>
                            <a class="dropdown-item  text-white " href="#">Project 2</a>
                        </div>
                    </li>


                    <li class="nav-item text-uppercase">
                        <a class="nav-link text-white px-3" href="#">Blog</a>
                    </li>
                    <li class="nav-item  text-uppercase">
                        <a class="nav-link  text-white px-3" href="#">Contact</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="border-line">

        </div>
    </header>

    <section id="enter" class="py-5">
        <div class="text-center py-5">
            <h2 class="p-3 display-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit, laboriosam!</h2>
            <a class="btn btn-outline-secondary btn-lg px-5" href="home">Enter</a>
        </div>
    </section>

    <footer class="mt-4">
        <div class="border-line">
        </div>

        <div class="bg-footer py-5">
            <p class=" text-center text-white m-0"> Copyright &copy; 2018 - HTML Bootstrap Template</p>
        </div>
    </footer>


</div>



<script src="/js/jquery-3.3.1.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.js"></script>

<script src="/js/main.js"></script>

</body>

</html>