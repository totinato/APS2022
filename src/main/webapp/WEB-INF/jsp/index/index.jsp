
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Projeto APS </title>
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"
    />
    <!-- Link Swiper's CSS -->
    <link    
      rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
    />
    <script
  src="https://code.jquery.com/jquery-3.6.1.js"
  integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
  crossorigin="anonymous"></script>
    <link href="<c:url value='/bibliotecas/css/style.css'/>" rel="stylesheet" type="text/css">

    <!-- Demo styles -->
    <style>
      html,
      body {
        position: relative;
        height: 100%;
      }

      body {
        background: #eee;
        font-family: Trebuchet MS,Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color: white;
        margin: 0;
        padding: 0;
      }

      .swiper {
        height: 100%;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;


        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        flex
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;   
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
        flex-direction: column;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
      #boxApp {
	    background-color: #FFF;
	    width: 100%;
	    max-width: 400px;
	    margin: 0px auto;
	    padding-top: 10px;
	    text-align: center;
	}	
	.swiper-pagination{
		height:0%;
		background-color:#6797f1;
		display: flex;
		position:absolute;
		flex-direction: row;
	    flex-wrap: wrap;
	    align-content: stretch;
	    justify-content: center;
	}
	.swiper-pagination-bullet{
		display: inline-block;
  		align-self: flex-end;
  		margin-bottom: 10px !important;

	}
	.swiper-wrapper{
		height: 100%;
	}
    </style>
  </head>

  <body>
  <main id="boxApp">
    <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
      <c:forEach items="${represa}" var="r">
        <div class="swiper-slide represa">

		<h1>${r.nome}</h1>
		<input class="volume" type="hidden" value="${r.volume_armazenado}">
        <p>Volume Armazenado- ${r.volume_armazenado}</p>
        <p>Pluviometria do dia - ${r.pluviometria_do_dia}</p>
        <p>Pluviometria do mês - ${r.pluviometria_acumulada_no_mes}</p>
        <p>Media historica do mês - ${r.media_historica_do_mes}</p>
        </div>
        </c:forEach>

      </div>
      <div class="swiper-pagination"></div>
    </div>
    </main>

    <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        pagination: {
          el: ".swiper-pagination",
        },
      });
      $(document).ready(function() {
    	  var coeficiente = 255/100;
    	  $(".represa").each(function(){
        	  var temperatura = $(this).children( ".volume" ).val()
        	  vtemperatura=temperatura.substring(0, temperatura.length - 2);
        	  temperatura=parseFloat(temperatura.toString().replace(',','.'));
        	  
        	  $(this).css("background-color", getcor(temperatura));
    	  });
      });
      
      function getcor(nr) {
    	    if (nr < 26) return 'tomato';
    	    if (nr < 51) return '#d8d62d';
    	    if (nr < 76) return '#6faeff';
    	    return 'green';
    	}
      

    </script>
  </body>
</html>

