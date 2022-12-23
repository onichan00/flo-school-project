<template>
  <div>
    <label for="file-upload-test">Selecteer een bestand: </label>
    <input ref="fileToUpload" type="file" id="file-upload-test">
    <button
        class="btn border border-dark"
        id="upload-file"
        @click.prevent="uploadFile">Upload bestand
    </button>
  </div>
</template>

<script>
export default {
  name: "FileUpload",
  methods: {
    uploadFile() {
      const data = new FormData();
      data.append(
          "file",
          this.$refs.fileToUpload.files[0]
      );

      fetch(`http://localhost:8080/api/files/upload/${localStorage.getItem("id")}`, {
        method: "POST",
        body: data
      }).then(response => {
        if (response.ok) {
          //TODO add proper feedback
          console.log("Good job! File uploaded!");
        }
      })
    }
  }
}
</script>

<style scoped>

</style>