window.addEventListener('load', function(){
  var hilightable = "input[type=text], input[type=password]";
  var fields = document.querySelectorAll(hilightable);
  var condition = document.getElementById("condition");
  for (i=0; i<fields.length; i++) {
    fields[i].addEventListener("focus", setBackground);
    fields[i].addEventListener("blur", setBackground);
  }

  document.getElementById('mainForm').addEventListener('submit', function(e){
    var hilightableRequired = document.getElementById('mainForm').getElementsByClassName('hilightable required');
    for(i = 0; i < hilightableRequired.length; i++){
      if(hilightableRequired[i].value==""){
        e.preventDefault();
        hilightableRequired[i].classList.add("error");
      }
      else{
        if(hilightableRequired[i].value!==""){
          hilightableRequired[i].classList.remove("error");
          e.preventDefault();
          window.location = "yelpMock_loggedin.html";
        }
      }
    }
  });




});


// function matchpass(){
// var pw1=document.f1.pw1.value;
// var pw2=document.f1.pw2.value;
//
// if(==secondpassword){
// return true;
// }
// else{
// alert("password must be same!");
// return false;
// }
// }


function setBackground(e) {
  var hilightableRequired = document.getElementById('mainForm').getElementsByClassName('hilightable required');
  for(i = 0; i < hilightableRequired.length; i++){
    if (e.type == "focus") {
      e.target.style.backgroundColor = "#FFE393";
      hilightableRequired[i].classList.remove("error");
    }
    else if (e.type == "blur") {
      e.target.style.backgroundColor = "white";
    }
  }
}
