function showDiv() {
  document.getElementById('results').style.display = "block";
}

function display(){
  $("#results").empty();
  var val =  $("input[type='text']").val();
  url = "https://opentable.herokuapp.com/api/restaurants?";
  data = "city=" + val;
  $.get(url,data).done(function(response){
    //  document.write(response.records[0].fields.state);
    $("#results").append('<h1>'+val+' Top restaurants</h1>');
    for (var i = 0; i<response.restaurants.length;i++){
      var dataSet =response.restaurants[i];
      $("#results").append('<h3><a href="review.html"><br><p>'+
      dataSet.name + '</p></a></h3>');
      $("#results").append('<p>'+ "Address: "+ dataSet.address+'</p>');
      $("#results").append('<p>'+ "Phone: "+ dataSet.phone+'</p> <br><br>');
    }
  });
}

$(document).ready(function(){
  $("#display").on("click",display);
});
