<?php
$filePath = "./../data/data-file.txt";
$data = file_get_contents($filePath);
echo $data;
?>