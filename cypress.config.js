const { defineConfig } = require("cypress");

module.exports = defineConfig({
  env:{
    base_url: 'http://localhost:50063'
  },
  e2e: {
    experimentalSessionAndOrigin:true,
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
