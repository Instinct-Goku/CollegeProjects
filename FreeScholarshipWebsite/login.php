<?php
$connect = mysqli_connect('localhost', 'root');

mysqli_select_db($connect, 'freescholarship');

$email = $_POST['email'];
$password = $_POST['pass'];
$user_search = "select * from student_data where email = '$email' ";
$query =  mysqli_query($connect, $user_search);
$email_count = mysqli_num_rows($query);

if($email_count) {
    $email_pass = mysqli_fetch_assoc($query);
    $real_pass = $email_pass['password'];
    $password_check = password_verify($password, $real_pass);
    if($password_check) {
        header("Refresh: 0; url=apply.html");
    }
    else{
        header("Refresh: 0; url=login.html");
        echo '<script>alert("incorrect password")</script>';
    }
}
else {
    header("Refresh: 0; url=login.html");
    echo '<script>alert("invalid email")</script>';
}
exit;

?>