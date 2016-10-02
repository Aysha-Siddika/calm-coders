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
}


?>

<html>
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
      <input type="text" name="un" placeholder="Username" class="form-control" required /><br/>
    </div>
     <div class="form-group">
    <input type="password" name="pass" placeholder="Password" class="form-control" required/><br/>
    </div>
     <div class="form-group">
     <input type="submit" name="submit" class="btn btn-primary pull-right" value="submit"/> 
        </div>
</form>
    </div>
  
    
   
 
    </div>
   
</body>

</html>