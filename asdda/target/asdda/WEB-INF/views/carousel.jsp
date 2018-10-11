

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <link rel="stylesheet" type="text/css"	href="resources/css/Carousel.css">
</head>
<body>
<!-- banner -->
<div class="container">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
          <li data-target="#myCarousel" data-slide-to="4"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/images/pic1.jpg" alt="Big Sale" style="width:100%;">
      </div>

      <div class="item">
        <img src="resources/images/pic2.jpg" alt="50% off" style="width:100%;">
      </div>
    
           
            <div class="item">
        <img src="resources/images/pic4.jpg" alt="Shop!Shop" style="width:100%;">
      </div>
      
            <div class="item">
        <img src="resources/images/pic5.jpg" alt="Shop soon before Sale Ends" style="width:100%;">
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>