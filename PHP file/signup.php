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
VALUES ( '$fname','$uname','$enpass','$enpass', '$en1','$en2','$en3','$en4')";
    
    if (mysqli_query($conn, $sql)) {
    echo "successfully account created";

}
 else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
mysqli_close($conn);
}
    
  

?>
    