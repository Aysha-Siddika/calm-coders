<?php
session_start();
if(!empty($_POST['pass']))
{
  include 'dbconnect.php';
    $uname = $_POST['un'];
    $pass = $_POST['pass'];
    $salt = "abcdefghijklmnopqrstuvwxyz";
    $temp_salt = md5($salt);
    $temppass= md5($pass);
    $enpass = md5($temppass.$temp_salt);
    
 	$query = "SELECT * FROM user_details1 WHERE username='$uname' AND password='$enpass'";
	$result= mysqli_query($conn,$query);
	$num_rows = mysqli_num_rows($result);
	
	
	if ($num_rows>0) 
{
		$rows = mysqli_fetch_assoc($result);
		$_SESSION['uname']=$rows['username'];
        $_SESSION['id']=$rows['id'];
          
            echo "login successfull";
	
	
	}
	else
	{	echo "<script type=\"text/javascript\">window.alert('Invalid User!');</script>";
		
	}
mysqli_close($conn);
}


?>