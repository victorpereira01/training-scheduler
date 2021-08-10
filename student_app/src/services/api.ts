import axios from 'axios'

const api = axios.create({
    baseURL: `http://{api_url}:8080`
})

export default api;