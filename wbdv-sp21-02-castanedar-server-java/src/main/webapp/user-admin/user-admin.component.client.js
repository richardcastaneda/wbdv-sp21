//Create necessary variables
var $createButton;
var $updateButton;
var $tableRows;
var $username;
var $password;
var $firstName;
var $lastName;
var $role;
var selectedUser = null
var userService = new AdminUserServiceClient()

// deleteUser function deletes a user
function deleteUser(event){
    var button = $(event.target)
    var index = button.attr("id")
    console.log(index)
    var id = users[index]._id
    userService.deleteUser(id)
      .then(function(status) {
        users.splice(index, 1)
        renderUsers(users)
      })
}

function createUser(){
    var newUser = {
      username: $username.val(),
      password: $password.val(),
      firstName: $firstName.val(),
      lastName: $lastName.val(),
      role: $role.val()
    }
    userService.createUser(newUser)
      .then(function(actualUser){
        users.push(actualUser)
        renderUsers(users)
      })
  clearForm()
}
/*clearForm function adapted from resource:
"https://www.w3schools.com/jsref/prop_reset_value.asp"*/
function clearForm(){
  document.getElementById("usernameFld").value = ""
  document.getElementById("passwordFld").value = ""
  document.getElementById("firstNameFld").value = ""
  document.getElementById("lastNameFld").value = ""
  document.getElementById("roleFld").value = ""
}

function selectUser(event) {
  var id = $(event.target).attr("id")
  selectedUser = users.find(user => user._id === id)
  $username.val(selectedUser.username)
  $password.val(selectedUser.password)
  $firstName.val(selectedUser.firstName)
  $lastName.val(selectedUser.lastName)
  $role.val(selectedUser.role)
}

  function updateUser() {
  selectedUser.username = $username.val()
    selectedUser.password = $password.val()
    selectedUser.firstName = $firstName.val()
    selectedUser.lastName = $lastName.val()
    selectedUser.role = $role.val()
  userService.updateUser(selectedUser._id, selectedUser)
    .then(status => {
      var index = users.findIndex(user => user._id === selectedUser)
      users[index] = selectedUser
      renderUsers(users)
    })
    clearForm()
}

function renderUsers(users) {
  $tableRows.empty()
  let asterisk = "*"
  for(var i=0; i<users.length; i++) {
    var user = users[i]
    $tableRows
    .prepend(`
      <tr>
          <td>${user.username}</td>
          <!--repeat function taken from resource
          "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/repeat"-->
          <td>${asterisk.repeat(user.password.length)}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.role}</td>
          <td>
            <span class="pull-right">
            <button id="${i}" class="fa-2x fa fa-times wbdv-remove"></button>
            <button id="${user._id}" class="fa-2x fa fa-pencil wbdv-edit"></button>
            </span>
          </td>
        </tr>`);
  }
  $(".wbdv-remove").click(deleteUser)
  $(".wbdv-edit").click(selectUser)
}

function main(){
  $tableRows = $("#table-rows")
  $createButton = $(".wbdv-create")
  $updateButton = $(".wbdv-update")
  $username = $("#usernameFld")
  $password = $("#passwordFld")
  $firstName = $("#firstNameFld")
  $lastName = $("#lastNameFld")
  $role = $("#roleFld")
  $updateButton.click(updateUser)
  $createButton.click(createUser)
  users = userService.findAllUsers().then(function(actualUsers){
    users = actualUsers
    renderUsers(users)
  })
}
$(main)