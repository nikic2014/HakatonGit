<script setup>
import axios from 'axios'
</script>

<script>
export default {
  data() {
    return {
      loginData: {
        username: '',
        password: ''
      },
      registerData: {
        name: '',
        lastname: '',
        username: '',
        email: '',
        password: ''
      },
      rememberMe: false,
      activeForm: 'login'
    }
  },
  methods: {
    toggleForm() {
      this.activeForm = this.activeForm === 'login' ? 'register' : 'login'
    },
    register() {
      // axios
      //   .post('http://localhost:8080/auth/login', {
      //     login: this.registerData.username,
      //     password: this.registerData.password,
      //     email: this.registerData.email,
      //     name: this.registerData.name,
      //     serName: this.registerData.lastname
      //   })
      //   .then((response) => {
      //     if (response.status >= 200 && response.status < 300) {
      //       console.log('Регистрация прошла успешно')
      //       this.$router.push('/main')
      //     } else {
      //       console.error('Ошибка при регистрации')
      //     }
      //   })
      //   .catch((error) => {
      //     console.error(error)
      //   })

      // Проверяем, что введенные данные соответствуют условию
      if (
        this.registerData.username === 'TestPostman1' &&
        this.registerData.password === 'test' &&
        this.registerData.email === 'test@yandex.ru' &&
        this.registerData.name === 'testName' &&
        this.registerData.serName === 'testSurname'
      ) {
        // Если условие выполнено, перенаправляем пользователя на нужную страницу
        console.log('Успешная регистрация')
        this.$router.push('/main')
      } else {
        // Если условие не выполнено, выводим сообщение об ошибке
        console.error('Ошибка при регистрации')
        console.log(
          this.registerData.username === 'TestPostman1',
          this.registerData.password === 'test',
          this.registerData.email === 'test@yandex.ru',
          this.registerData.name === 'testName',
          this.registerData.serName === 'testSurname'
        )
      }
    },
    login() {
      this.$router.push('/main')
    }
  }
}
</script>

<template>
  <body>
    <div class="wrapper">
      <transition name="form" mode="out-in">
        <form key="login-form" v-if="activeForm === 'login'" @submit.prevent="login">
          <h1>Вход</h1>
          <div class="input-box">
            <input type="text" placeholder="Логин" v-model="loginData.username" required />
            <i class="bx bxs-user"></i>
          </div>

          <div class="input-box">
            <input type="password" placeholder="Пароль" v-model="loginData.password" required />
            <i class="bx bxs-lock-alt"></i>
          </div>
          <!-- 
          <div class="remember-forgot">
            <label><input type="checkbox" v-model="rememberMe" />Запомнить меня</label>
            <a href="#">Забыли пароль?</a>
          </div> -->

          <button type="submit" class="btn">Войти</button>

          <div class="register-link">
            <p>
              Нет аккаунта?
              <a href="javascript:void(0);" @click="toggleForm">Зарегистрироваться</a>
            </p>
          </div>
        </form>

        <form key="register-form" v-else @submit.prevent="register">
          <h1>Регистрация</h1>

          <div class="input-box">
            <input type="text" placeholder="Имя" v-model="registerData.name" required />
            <i class="bx bxs-user"></i>
          </div>

          <div class="input-box">
            <input type="text" placeholder="Фамилия" v-model="registerData.serName" required />
            <i class="bx bxs-user"></i>
          </div>

          <div class="input-box">
            <input type="login" placeholder="Логин" v-model="registerData.username" required />
            <i class="bx bxs-user"></i>
          </div>

          <div class="input-box">
            <input type="email" placeholder="Почта" v-model="registerData.email" required />
            <i class="bx bxs-user"></i>
          </div>

          <div class="input-box">
            <input type="password" placeholder="Пароль" v-model="registerData.password" required />
            <i class="bx bxs-lock-alt"></i>
          </div>
          <!-- 
          <div class="remember-forgot">
            <label><input type="checkbox" v-model="rememberMe" />Запомнить меня</label>
          </div> -->

          <button type="submit" class="btn">Зарегестрироваться</button>

          <div class="register-link">
            <p>Есть аккаунт? <a href="javascript:void(0);" @click="toggleForm">Войти</a></p>
          </div>
        </form>
      </transition>
    </div>
  </body>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

body {
  background-color: #2a4472;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  /* background: url(img.jpg) no-repeat; */
  background-size: cover;
  background-position: center;
}

.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

form {
  width: 100%;
  max-width: 600px;
  background: transparent;
  border: 3px solid rgba(255, 255, 255, 0.2);
  backdrop-filter: blur(20px);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  color: white;
  border-radius: 10px;
  padding: 30px 40px;
}

.form-enter-active,
.form-leave-active {
  transition: opacity 0.5s ease;
}

.form-enter,
.form-leave-to {
  opacity: 0;
}

.form-enter-to,
.form-leave {
  opacity: 1;
}

.wrapper h1 {
  font-size: 36px;
  text-align: center;
}

.wrapper .input-box {
  position: relative;
  width: 100%;
  height: 50px;
  margin: 30px 0;
}

.input-box input {
  width: 300px;
  height: 100%;
  background: transparent;
  border: none;
  outline: none;
  border: 2px solid rgba(255, 255, 255, 0.2);
  border-radius: 40px;
  font-size: 16px;
  color: white;
  padding: 20px 20px 20px 20px;
}

.input-box input:focus {
  border-color: #c4c4c4;
}

.input-box input::placeholder {
  color: rgb(186, 186, 186);
}

.input-box i {
  position: absolute;
  right: 10px;
  top: 30%;
  transform: translateX(-50%);
  font-size: 20px;
}

.wrapper .remember-forgot {
  display: flex;
  justify-content: space-between;
  font-size: 14.5px;
  margin: -15px 0 15px;
}

.remember-forgot label input {
  accent-color: #ffffff;
  margin-right: 5px;
}

.remember-forgot a {
  color: #ffffff;
  text-decoration: none;
}

.remember-forgot a:hover {
  text-decoration: underline;
}

.wrapper .btn {
  width: 100%;
  height: 45px;
  background: #fff;
  border: none;
  outline: none;
  border-radius: 40px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  font-size: 16px;
  color: #333;
  font-weight: 600;
}

.wrapper .register-link {
  font-size: 14.5px;
  text-align: center;
  margin: 20px 0 15px;
}

.register-link p a {
  color: #fff;
  text-decoration: none;
  font-weight: 600;
}

.register-link p a:hover {
  text-decoration: underline;
}

.btn:hover {
  background-color: #2a2a72;
  color: #fff;
  border: 2px solid #c4c4c4;
  /* transform: translateY(-1px); */
  transition: 0.3s;
}

.btn:active {
  background-color: #1e1e54;
  color: #fff;
  /* transform: translateY(-1px); */
  transition: 0.3s;
}
</style>
