/*ログインにJSを使用している*/

$('.message a').click(function () {
  $('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
});


const passwordToggle = document.querySelectorAll('.js-password-toggle');

for (let i = 0; i < 2; i++) {
  passwordToggle[i].addEventListener('change', function () {
    const password = document.querySelectorAll('.js-password'),
      passwordLabel = document.querySelectorAll('.js-password-label');
    if (password[i].type === 'password') {
      password[i].type = 'text';
      passwordLabel[i].innerHTML = '<i class="fas fa-eye-slash"></i>';
    } else {
      password[i].type = 'password';
      passwordLabel[i].innerHTML = '<i class="fas fa-eye"></i>';
    }
    password[i].focus();
  });
}
