/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html",'./public/**/*.html', './src/**/*.{vue,js,ts,jsx,tsx}', './node_modules/flowbite/**/*.js' ],
  theme: {
    extend: {
      colors: {
       florijnOrange: {
          DEFAULT: "#ec5a29",
              100: "#ec5827",
              200: "#cd3d0d",
              300: "#af1f00",
              400: "#920000",
              500: "#760000",
              600: "#5c0000"
        },
        florijnGray: "#919194"
      }
    },
  },
  plugins: [
    require('flowbite/plugin')
  ]
}
