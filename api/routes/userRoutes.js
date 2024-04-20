const route = require("express").Router();
const {
  userRegister,
  userLogin,
  individualUser,
  updateUser,
} = require("../controllers/userControllers");


// user register
route.post("/register", userRegister);

// user login
route.post("/login", userLogin);

 // get user by id
 route.get("/:id", individualUser);

route.post("/updateprofile/:id",updateUser)

module.exports = route;
