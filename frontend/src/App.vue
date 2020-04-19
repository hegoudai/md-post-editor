<template>
  <div id="main">
    <h1>Md-Post-Editor</h1>
    <mavon-editor id="editor" 
    ref=md
    placeholder="开始编辑你的博客吧..." 
    @imgAdd="$imgAdd" 
    v-model="value"/>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  data() {
    return {value: ''}
  },
  methods: {
    $imgAdd(post, $file) {
      var formdata = new FormData()
      formdata.append('image', $file)
      axios({
        method: 'POST',
        url: 'http://localhost:4001/upload',
        data: formdata,
        headers: { 'Content-Type': 'multipart/form-data' }
      }).then( resp => {
        this.$refs.md.$img2Url(post, resp.data);
      })
    }
  }
}
</script>

<style>
#main {
  text-align: center;
  margin-top: 60px;
}
#editor {
  height: 800px;
}
</style>
