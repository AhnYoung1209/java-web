$(function(){
   $( "form" ).submit(function( event ) {
   alert( "ע��ɹ���" );
       $.ajax({
  url: "success.json
}).done(function(data) {
  if ( console && console.log ) {
      console.dir(data);
      alert(data.msg);
     }
   });
 });
})
         