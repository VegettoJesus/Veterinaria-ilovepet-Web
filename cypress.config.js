const { defineConfig } = require("cypress");

module.exports = defineConfig({
  env:{
    base_url: 'http://localhost:49724'
  },
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
