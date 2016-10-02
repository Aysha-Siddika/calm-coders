<?php
// session for checking weather the user is logged in or not it not means it will navigate to signinpage

session_start();
if(!isset($_SESSION['uname'])){

 	echo "<script type=\"text/javascript\">
 	window.alert('login first');
 	window.location.href='index.php';
 	</script>";
	}  
// if user clicked logout button the following command will close the current user session
if(isset($_POST['logout'])){
   session_unset();
    session_destroy();   
     	echo "<script type=\"text/javascript\">
 	window.alert('Logout Success');
 	window.location.href='index.php';
 	</script>";
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
     
                <?php echo "Hellowww!!!!!&nbsp;".$_SESSION['uname']?>
               
               <br/><br/><br/>
               
               <form action="" method="post">
                <div class="form-group">
                    <a href="update.php" class="btn btn-success">Update</a>
                    <input type="submit" class="btn btn-danger pull-right" value="Logout" name="logout"/>   
                </div>
               </form>
    </div>
  
    
   
 
    </div>
   
</body>

</html>