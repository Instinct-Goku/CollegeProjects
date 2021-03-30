<?php
$connect = mysqli_connect('localhost', 'root');

mysqli_select_db($connect, 'freescholarship');


$name = $_POST['input_name'];
$father = $_POST['input_father'];
$mobile = $_POST['input_mobile'];
$email = $_POST['input_email'];
$address = $_POST['input_address'];
$qualification = $_POST['input_qualification'];
$photo = $_FILES['input_photo'];


$filename = $photo['name'];
$filepath = $photo['tmp_name'];
$fileerror = $photo['error'];

if($fileerror == 0) {
    $dest = 'upload/'.$filename;
    move_uploaded_file($filepath, $dest);
    echo '$name';
    $query = "insert into scholarship_data(name,father,mobile,email,address,qualification,photo)
    values('$name','$father','$mobile','$email','$address','$qualification','$dest')";
    
    mysqli_query($connect, $query);
    #header("Refresh: 0; url=apply.html");
   #echo '<script>alert("Application submitted successfully!")</script>';
  exit;
}
?>

$query = "insert into student_data(username,email,password)
    values('$username','$email', '$password')";
    