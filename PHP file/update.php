<?php
   // session for checking weather the user is logged in or not it not means it will navigate to signinpage
   session_start();
   if(!isset($_SESSION['uname'])){
       
           
    	echo "<script type=\"text/javascript\">
    	window.alert('login first');
    	window.location.href='index.php';
    	</script>";
   	}
   
   if(!empty($_POST['en1']))
   {
         $id = $_SESSION['id'];
      include 'dbconnect.php';
       
     $uname = $_POST['un'];
     $en1 = $_POST['en1'];
     $en1 = $_POST['en2'];
     $en1 = $_POST['en3'];
     $en1 = $_POST['en4'];
   

       
     // sql command to update value to the file here we using session id that means it already have the current user column id
       
    $sql = "UPDATE user_details1 SET username='$uname' ,emergency_no1='$en1' ,emergency_no1='$en2',emergency_no1='$en3',emergency_no4='$en4' WHERE id=$id";
       
       if (mysqli_query($conn, $sql)) {
       echo "<script type=\"text/javascript\">
    	window.alert('updated successfully login with your new username');
    	window.location.href='index.php';
    	</script>";
           session_unset();
    session_destroy();  
   
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
               <input type="text" name="un" placeholder="Username" class="form-control"  required /><br/>
            </div>
            <div class="form-group">
               <input type="number" name="en1" placeholder="Emergency_no1" class="form-control"  required /><br/>
            </div>
            <div class="form-group">
               <input type="submit" name="submit" class="btn btn-primary pull-right" value="submit"/> 
            </div>
         </form>
      </div>
   </div>
</body>
</html>
