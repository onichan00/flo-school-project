<template>
  <div class="file-list-container border border-light max-w-xl rounded">
    <section class="bg-gray-50 file-list-header border-b border-light flex justify-around text-xs uppercase dark:text-gray-400 font-bold">
      <span>BESTANDSNAAM</span><span>UPLOADDATUM</span>
    </section>
    <ul class="file-list list-none">
      <li class="relative h-10 flex justify-around items-center" v-for="file in files" :key="file.id">
        <span class="cursor-pointer ml-6 text-blue-600 underline"
              @click="downloadFile(file.id, file.name)">{{ file.name }} <!-- TODO add file timestamps -->
        </span>
        <span>{{ this.formatTimestamp(file) }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "FileList",
  data () {
    return {
      files: [],
      userId: localStorage.getItem("id"),
      baseUrl: `${process.env.VUE_APP_API_URL}/api/files`
    }
  },
  methods: {
    fetchFiles() {
      fetch(`${this.baseUrl}/list/${this.userId}`)
          .then(response => {
            if (response.ok) {
              return response.json();
            }
          })
          .then(data => {
            data.forEach(file => {
              this.files.push(file);
            })
          })
    },
    downloadFile(fileId, fileName) {
      fetch(`${this.baseUrl}/${fileId}`, {
        headers: {
          "Content-Type": "application;octet-stream"
        }
      }).then(response => {
        if (response.ok) {
          return response.blob();
        }
      }).then(data => {
        const link = document.createElement("a");
        link.href = URL.createObjectURL(data);
        link.download = fileName;
        link.click();
        link.remove();
      })
    },
    formatTimestamp(file) {
      const timestamp = new Date(file.timestamp);
      return `${timestamp.getDate()}-${timestamp.getMonth() + 1}-${timestamp.getFullYear()}`;
    }
  },
  mounted() {
    this.fetchFiles();
  }
}
</script>

<style scoped>

</style>