(function () {

  const userService = new UserService();
  const rowTemplate = jQuery('wbdv-template');
  const tbody = jQuery('tbody');

  jQuery(main);

  function main() {
    userService
      .findAllUsers()
      .then(renderUsers);

  }

  function renderUsers(users) {
    for (const u in users) {
      const user = users[u];
      const rowClone = rowTemplate.clone();
      rowClone.removeClass('wbdv-hidden');
      rowClone.find('.wbdv-username').html(user.username);
      tbody.append(rowClone);
    }
  }
})()