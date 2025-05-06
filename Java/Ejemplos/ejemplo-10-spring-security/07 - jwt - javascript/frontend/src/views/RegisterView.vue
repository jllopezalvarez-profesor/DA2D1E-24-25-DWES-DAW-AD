<template>
  <div>
    <h2>Registro</h2>
    <form @submit.prevent="register">
      <input v-model="firstName" placeholder="Nombre" type="text"/>
      <input v-model="lastName" placeholder="Apellidos" type="text"/>
      <input v-model="email" placeholder="Email" type="email"/>
      <input v-model="password" type="password" placeholder="Contraseña"/>
      <input v-model="repeatPassword" type="password" placeholder="Repetir contraseña"/>
      <button type="submit">Registrar</button>
    </form>
    <p v-if="error">{{ error }}</p>
    <router-link to="/login">Ya tengo cuenta</router-link>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue'
import axios from 'axios'
import {useRouter} from 'vue-router'

const firstName = ref('');
const lastName = ref('');
const email = ref('')
const password = ref('')
const repeatPassword = ref('')
const error = ref('')
const router = useRouter()

const register = async () => {
  try {
    await axios.post('/api/v1/auth/register', {
      firstName: firstName.value,
      lastName: lastName.value,
      email: email.value,
      password: password.value
    })
    await router.push('/login')
  } catch {
    error.value = 'Error al registrar'
  }
}
</script>
