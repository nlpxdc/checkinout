const AdminIndexPage = {
    name: 'AdminIndexPage',
    template: `
        <div id="AdminIndexPage">
            <mt-cell title="用户列表" is-link to="/UserIndexPage"></mt-cell>
            <mt-cell title="打卡列表" is-link to="/CheckRecordIndexPage"></mt-cell>
        </div>
    `
};