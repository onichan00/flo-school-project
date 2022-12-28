<template>
  <div class="file-list-container border border-light max-w-2xl rounded">
    <section class="file-list-header border-b border-light flex justify-around">
      <span>BESTANDSNAAM</span><span>UPLOADDATUM</span>
    </section>
    <ul class="file-list list-none">
      <li class="relative h-10 flex justify-around items-center" v-for="file in files" :key="file.id">
        <input class="absolute left-2 top-3" type="checkbox" :value="file.id">
        <span class="cursor-pointer ml-6 text-blue-600 underline"
              @click="downloadFile(file.id, file.name)">{{ file.name }} <!-- TODO add file timestamps -->
        </span>
        <span>{{ file.timestamp }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "FileList",
  data () {
    return {
      files: []
    }
  },
  methods: {
    fetchFiles() {
      fetch(`${process.env.VUE_APP_API_URL}/api/files/list/${localStorage.getItem("id")}`)
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
    downloadFile(id, fileName) {
      const url = process.env.VUE_APP_API_URL +
      // queries database for specific file
      fetch(`${process.env.VUE_APP_API_URL}/api/files/${id}`, {
        headers: {
          "Content-Type": "application;octet-stream"
        }
      }).then(response => {
        if (response.ok) {
          return response.blob(); // .blob() makes it downloadable as a file
        }
      }).then(data => {
        // creates, clicks, and removes a download link for the blobbed response
        const url = URL.createObjectURL(data);
        const link = document.createElement("a");
        link.href = url;
        link.download = fileName;
        link.click();
        link.remove();
      })
    }
  },
  mounted() {
    this.fetchFiles();
  }
}
</script>

<style scoped>

</style>