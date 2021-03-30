<?php
$connect = mysqli_connect('localhost', 'root');

mysqli_select_db($connect, 'freescholarship');

$username = $_POST['username'];
$password = password_hash($_POST['pass'], PASSWORD_BCRYPT);
$email = $_POST['email'];
$user_search = "select * from student_data where email = '$email' ";
$query =  mysqli_query($connect, $user_search);
$email_count = mysqli_num_rows($query);

if($email_count) {
    header("Refresh: 0; url=login.html");
    echo '<script>alert("user already exist!")</script>';
}
else {
    $query = "insert into student_data(username,email,password)
    values('$username','$email', '$password')";
    
    mysqli_query($connect, $query);
    header("Refresh: 0; url=login.html");
    echo '<script>alert("user signed-in successfully!")</script>';
    exit;
}

?>