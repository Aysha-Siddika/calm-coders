<?php
  
if(!empty($_POST['pass']))
{
   include 'dbconnect.php';
      $fname = $_POST['fn'];
  $uname = $_POST['un'];
    $pass = $_POST['pass'];
    $cpass = $_POST['cpass'];
    $en1 = $_POST['en1'];
    $en2 = $_POST['en2'];
    $en3 = $_POST['en3'];
    $en4 = $_POST['en4'];
    $salt = "abcdefghijklmnopqrstuvwxyz";
    
    $temp_salt = md5($salt);
    $temppass= md5($pass);
    $enpass = md5($temppass.$temp_salt);
    
  
 $sql = "INSERT INTO user_details1 (fullname, username,password,confirm_password,emergency_no1,emergency_no2,emergency_no3,emergency_no4)
VALUES ( '$fname','$uname','$enpass','$enpass', '$en1l','$en2','$en3','$en4')";
    
    if (mysqli_query($conn, $sql)) {
    echo "successfully account created";

} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}
    
  

?>
    <head>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
<body>
    <div class="container">
        <div class="col-lg-4 col-md-4">
        
        </div>
           <div class="col-lg-4 col-md-4 well" style="margin-top:20%;">
            <form action="" class="form" method="post">
  <div class="form-group">
      <input type="text" name="fn" placeholder="Fullname" class="form-control" required /><br/>
    </div>
     
 <div class="form-group">
      <input type="text" name="un" placeholder="Username" class="form-control" required /><br/>
    </div>
               
     
<div class="form-group">
    <input type="password" name="pass" placeholder="Password" class="form-control" required/><br/>
    </div>
<div class="form-group">
    <input type="password" name="cpass" placeholder="Confirm_Password" class="form-control" required/><br/>
    </div>
<div class="form-group">
    <input type="number" name="en1" placeholder="Emergency_no1" class="form-control" required/><br/>
    </div>
 <div class="form-group">
    <input type="number" name="en2" placeholder="Emergency_no2" class="form-control" required/><br/>
    </div>
<div class="form-group">
    <input type="number" name="en3" placeholder="Emergency_no3" class="form-control" required/><br/>
    </div>
<div class="form-group">
    <input type="number" name="en4" placeholder="Emergency_no4" class="form-control" required/><br/>
    </div>


   
     <div class="form-group">
     <input type="submit" name="submit" class="btn btn-primary pull-right" value="submit"/> 
        </div>
</form>
    </div>
  
    
   
 
    </div>
   
</body>

</html>