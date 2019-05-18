import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { withStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import CssBaseline from '@material-ui/core/CssBaseline';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import TextField from '@material-ui/core/TextField';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import MailIcon from '@material-ui/icons/Mail';
import Button from '@material-ui/core/Button';
import $ from 'jquery';

const drawerWidth = 240;

const styles = theme => ({
    root: {
        display: 'flex',
    },
    appBar: {
        transition: theme.transitions.create(['margin', 'width'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
    },
    appBarShift: {
        width: `calc(100% - ${drawerWidth}px)`,
        marginLeft: drawerWidth,
        transition: theme.transitions.create(['margin', 'width'], {
            easing: theme.transitions.easing.easeOut,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    menuButton: {
        marginLeft: 12,
        marginRight: 20,
    },
    hide: {
        display: 'none',
    },
    drawer: {
        width: drawerWidth,
        flexShrink: 0,
    },
    drawerPaper: {
        width: drawerWidth,
    },
    drawerHeader: {
        display: 'flex',
        alignItems: 'center',
        padding: '0 8px',
        ...theme.mixins.toolbar,
        justifyContent: 'flex-end',
    },
    content: {
        flexGrow: 1,
        padding: theme.spacing.unit * 3,
        transition: theme.transitions.create('margin', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
        marginLeft: -drawerWidth,
    },
    contentShift: {
        transition: theme.transitions.create('margin', {
            easing: theme.transitions.easing.easeOut,
            duration: theme.transitions.duration.enteringScreen,
        }),
        marginLeft: 0,
    },
});

var hide = {
    display: "none",
};

var show = {
    display: "inline"
};

class PersistentDrawerLeft extends React.Component {
    state = {
        open: false,
        showLogin: show,
        showFunc: hide
    };

    handleDrawerOpen = () => {
        this.setState({ open: true });
    };

    handleDrawerClose = () => {
        this.setState({ open: false });
    };

    handleShowLogin = () => {
        this.setState({
            showLogin: show,
            showFunc: hide,
        })
    };

    handleShowFunc = () => {
        this.setState({
            showLogin: hide,
            showFunc: show,
        })
    };

    handleLogin = () => {
        let saveDataAry = {
            username: document.getElementById("loginName").value,
            password: document.getElementById("loginPassword").value,
        };
        if(saveDataAry["username"] === "" || saveDataAry["password"] === "")
            alert("请输入用户名或密码");
        else{
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/login",
                contentType: 'application/json',
                data: JSON.stringify(saveDataAry),
                success: function (data) {
                    console.log(data);
                    alert("welcome!");
                }
            });
        }
    };

    handleFunc = () => {
        let fr = document.getElementById("from").value;
        let to = document.getElementById("to").value;
        if(fr === "" || to === "")
            alert("请填上所有的空!");
        else{
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/wordladder?from=" + fr + "&to=" + to,
                success: function (data) {
                    console.log(data);
                    alert("使用成功!");
                }
            });
        }
    };

    render() {
        const { classes, theme } = this.props;
        const { open } = this.state;

        return (
            <div className={classes.root}>
                <CssBaseline />
                <AppBar
                    position="fixed"
                    className={classNames(classes.appBar, {
                        [classes.appBarShift]: open,
                    })}
                >
                    <Toolbar disableGutters={!open}>
                        <IconButton
                            color="inherit"
                            aria-label="Open drawer"
                            onClick={this.handleDrawerOpen}
                            className={classNames(classes.menuButton, open && classes.hide)}
                        >
                            <MenuIcon />
                        </IconButton>
                        <Typography variant="h6" color="inherit" noWrap>
                            wl
                        </Typography>
                    </Toolbar>
                </AppBar>
                <Drawer
                    className={classes.drawer}
                    variant="persistent"
                    anchor="left"
                    open={open}
                    classes={{
                        paper: classes.drawerPaper,
                    }}
                >
                    <div className={classes.drawerHeader}>
                        <IconButton onClick={this.handleDrawerClose}>
                            {theme.direction === 'ltr' ? <ChevronLeftIcon /> : <ChevronRightIcon />}
                        </IconButton>
                    </div>
                    <Divider />
                    <List>
                        <ListItem button onClick={this.handleShowLogin}>
                            <ListItemIcon><InboxIcon /></ListItemIcon>
                            <ListItemText primary={"登录"} />
                        </ListItem>
                        <ListItem button onClick={this.handleShowFunc}>
                            <ListItemIcon><MailIcon /></ListItemIcon>
                            <ListItemText primary={"word ladder"} />
                        </ListItem>
                    </List>
                    <Divider />
                </Drawer>
                <main
                    className={classNames(classes.content, {
                        [classes.contentShift]: open,
                    })}
                >
                    <div className={classes.drawerHeader} />
                    <div style={this.state.showLogin}>
                        <TextField
                            required
                            autoFocus
                            margin="dense"
                            id="loginName"
                            label="用户名"
                            type="username"
                            helperText=""
                            fullWidth
                        />
                        <TextField
                            required
                            autoFocus
                            margin="dense"
                            id="loginPassword"
                            label="密码"
                            type="password"
                            autoComplete="current-password"
                            fullWidth
                        />
                        <Button onClick={this.handleLogin} color="primary">
                            登录
                        </Button>
                    </div>
                    <div style={this.state.showFunc}>
                        <TextField
                            required
                            autoFocus
                            margin="dense"
                            id="from"
                            label="from"
                            type="text"
                            helperText=""
                            fullWidth
                        />
                        <TextField
                            required
                            autoFocus
                            margin="dense"
                            id="to"
                            label="to"
                            type="text"
                            fullWidth
                        />
                        <Button onClick={this.handleFunc} color="primary">
                            使用word ladder
                        </Button>
                    </div>
                </main>
            </div>
        );
    }
}

PersistentDrawerLeft.propTypes = {
    classes: PropTypes.object.isRequired,
    theme: PropTypes.object.isRequired,
};

export default withStyles(styles, { withTheme: true })(PersistentDrawerLeft);