<?php include 'functions.inc.php' ?>

<html>
  <body>
    <header>
      <h1> Activity 10 - PHP </h1>
    </header>
    <main>
    <h2><?php echo greetings().$_GET['user'].'!';?></h2>

    <div id="compute">
      Here is your lucky number:  <?php echo compute($_GET['number1'], $_GET['number2'], $_GET['operator']); ?>
    </div>
    </main>
    <?php include 'footer.inc.html' ?>
  </body>
</html>
