const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  roles: state => state.user.roles,
  navTree:state => state.menu.navTree,
  perms:state => state.user.perms,
  current_role:state => state.user.current_role
}
export default getters
