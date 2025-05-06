<template>
  <div>
    <h2>Tareas</h2>
    <ul>
      <li v-for="task in tasks" :key="task.taskId">{{ task.title }} - {{ task.categoryName }} -
        {{ task.status }}
      </li>
    </ul>
    <button @click="logout">Cerrar sesión</button>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue'
import axios from 'axios'
import {useRouter} from 'vue-router'
import {useAuthStore} from '../stores/auth'


interface Task {
  taskId: number;
  title: string;
  description?: string;
  status: string;
  categoryName: string;
}

const tasks = ref<Task[]>([])
const router = useRouter()
const auth = useAuthStore()

const fetchTasks = async () => {
  try {
    const response = await axios.get<Task[]>('/api/v1/tasks', {
      headers: {
        Authorization: `Bearer ${auth.accessToken}`
      }
    })
    tasks.value = response.data
  } catch {
    auth.clearToken()
    await router.push('/login')
  }
}

const logout = () => {
  auth.clearToken()
  router.push('/login')
}

onMounted(fetchTasks)
</script>
