<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <input v-model="email" placeholder="Correo electrónico" />
      <input v-model="password" type="password" placeholder="Contraseña" />
      <button type="submit">Entrar</button>
    </form>
    <p v-if="error">{{ error }}</p>
    <router-link to="/register">¿No tienes cuenta?</router-link>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/auth'

const email = ref('')
const password = ref('')
const error = ref('')
const router = useRouter()
const auth = useAuthStore()

const login = async () => {
  try {
    const response = await axios.post('/api/v1/auth/login', {
      email: email.value,
      password: password.value
    })
    auth.setToken(response.data.accessToken)
    await router.push('/tasks')
  } catch {
    error.value = 'Credenciales inválidas'
  }
}
</script>
