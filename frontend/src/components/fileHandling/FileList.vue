<template>
  <div class="file-list-container border border-light max-w-2xl rounded">
    <section class="file-list-header border border-light flex justify-around">
      <span>BESTANDSNAAM</span><span>UPLOADDATUM</span>
    </section>
    <ul class="file-list list-none">
      <li class="relative h-10" v-for="file in files" :key="file.id">
        <input class="absolute left-2 top-3" type="checkbox" :value="file.id">
        {{ file.id }} <!-- TODO add file timestamps -->
      </li>
    </ul>
  </div>



<!--  <div class="file-list-container">-->
<!--    <h2>Uploaded Files:</h2>-->
<!--    <ul class="list-disc">-->
<!--      <li v-for="file in files"-->
<!--          :key="file.id">-->
<!--        <span class="cursor-pointer" @click="downloadFile(file.id, file.name)">{{ file.name }}</span>-->
<!--      </li>-->
<!--    </ul>-->
<!--  </div>-->
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
      fetch("http://localhost:8080/api/files/list")
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
      // queries database for specific file TODO: make fetch URL more dynamic
      fetch(`http://localhost:8080/api/files/download/${id}`, {
        headers: {
          "Content-Type": "image/png"
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