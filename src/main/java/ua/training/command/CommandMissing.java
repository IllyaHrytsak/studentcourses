/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.training.command;

import ua.training.entity.User;
import ua.training.manager.Config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommandMissing implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            CommandHelper commandHelper = CommandHelper.getInstance();
            page = commandHelper.checkUser(request.getSession(), user);
        } else {
            page = Config.getInstance().getProperty(Config.LOGIN);
        }
        return page;
    }
}
