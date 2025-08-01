import {fileURLToPath, URL} from 'node:url'

import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  optimizeDeps: {
    exclude: ['js-big-decimal']
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8081',
        rewrite: (path) => path.replace(/^\/api/, ''),
        changeOrigin: true
      }
    }
  }
})
