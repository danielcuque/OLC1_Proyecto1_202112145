package com.daniel.model;

import com.daniel.controller.ExceptionReport;

import java.io.*;
import java.util.ArrayList;

public class ReportHTML {
    // TODO: Implement style for HTML report
    private String cssStyles() {

        String styles = "<style>\n" +
                "html {\n" +
                "  line-height: 1.15;\n" +
                "  -webkit-text-size-adjust: 100%;\n" +
                " font-family: 'Inter', sans-serif; "+
                "}\n" +
                ".flex {\n" +
                "  display: flex;\n" +
                "}\n" +
                ".flex-col {\n" +
                "  flex-direction: column;\n" +
                "}\n" +
                ".my-10 {\n" +
                "  margin-top: 2.5rem;\n" +
                "  margin-bottom: 2.5rem;\n" +
                "}\n" +
                ".mx-2 {\n" +
                "  margin-left: 0.5rem;\n" +
                "  margin-right: 0.5rem;\n" +
                "}\n" +
                ".text-4xl {\n" +
                "  font-size: 2.25rem;\n" +
                "}\n" +
                ".mb-5 {\n" +
                "  margin-bottom: 1.25rem;\n" +
                "}\n" +
                ".text-center {\n" +
                "  text-align: center;\n" +
                "}\n" +
                ".font-medium {\n" +
                "  font-weight: 500;\n" +
                "}\n" +
                ".relative {\n" +
                "  position: relative;\n" +
                "}\n" +
                ".overflow-x-auto {\n" +
                "  overflow-x: auto;\n" +
                "}\n" +
                ".w-full {\n" +
                "  width: 100%;\n" +
                "}\n" +
                ".text-sm {\n" +
                "  font-size: 0.875rem;\n" +
                "}\n" +
                ".text-left {\n" +
                "  text-align: left;\n" +
                "}\n" +
                ".text-gray-400 {\n" +
                "  color: #cbd5e0;\n" +
                "}\n" +
                ".bg-black {\n" +
                "  background-color: #000000;\n" +
                "}\n" +
                ".rounded-xl {\n" +
                "  border-radius: 0.75rem;\n" +
                "}\n" +
                ".text-xs {\n" +
                "  font-size: 0.75rem;\n" +
                "}\n" +
                ".text-gray-900 {\n" +
                "  color: #1a202c;\n" +
                "}\n" +
                ".uppercase {\n" +
                "  text-transform: uppercase;\n" +
                "}\n" +
                ".px-6 {\n" +
                "  padding-left: 1.5rem;\n" +
                "  padding-right: 1.5rem;\n" +
                "}\n" +
                ".py-3 {\n" +
                "  padding-top: 0.75rem;\n" +
                "  padding-bottom: 0.75rem;\n" +
                "}\n" +
                ".bg-white {\n" +
                "  background-color: #ffffff;\n" +
                "}\n" +
                ".font-medium {\n" +
                "  font-weight: 500;\n" +
                "}\n" +
                ".text-white {\n" +
                "  color: #ffffff;\n" +
                "}\n" +
                ".whitespace-nowrap {\n" +
                "  white-space: nowrap;\n" +
                "}\n" +
                ".px-6 {\n" +
                "  padding-left: 1.5rem;\n" +
                "  padding-right: 1.5rem;\n" +
                "}\n" +
                ".py-4 {\n" +
                "  padding-top: 1rem;\n" +
                "  padding-bottom: 1rem;\n" +
                "}\n" +
                "</style>\n";

        return styles;
    }

    private String htmlHeader() {
        String header = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "\n" +
                "    <title>Tabla de errores</title>\n" +
                "  </head>\n";
        return header;
    }

    private String htmlBody(ArrayList<ExceptionReport> exceptions) {
        String body = "";
        body += "<div class=\"flex flex-col my-10 mx-2\">\n" +
                "<h1 class=\"text-4xl mb-5 text-center font-medium\">Tabla de reportes</h1>\n" +
                "<div class=\"relative overflow-x-auto\">\n" +
                "    <table class=\"w-full text-sm text-left text-gray-400 bg-black rounded-xl\">\n" +
                "        <thead class=\"text-xs uppercase text-gray-400\">\n" +
                "            <tr>\n" +
                "                <th scope=\"col\" class=\"px-6 py-3\">\n" +
                "                    Tipo de error\n" +
                "                </th>\n" +
                "                <th scope=\"col\" class=\"px-6 py-3\">\n" +
                "                    Descripción\n" +
                "                </th>\n" +
                "                <th scope=\"col\" class=\"px-6 py-3\">\n" +
                "                    Línea\n" +
                "                </th>\n" +
                "                <th scope=\"col\" class=\"px-6 py-3\">\n" +
                "                    Columna\n" +
                "                </th>\n" +
                "            </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n";
        for (ExceptionReport exception : exceptions) {
            body += "<tr>\n"+
                    "<th scope=\"row\" class=\"px-6 py-4 font-medium whitespace-nowrap text-white\">\n" +
                    "                    "+ exception.type +"\n" +
                    "                </th>\n" +
                    "                <td class=\"px-6 py-4\">\n" +
                    "                    "+ exception.description+"\n" +
                    "                </td>\n" +
                    "                <td class=\"px-6 py-4\">\n" +
                    "                    "+ exception.line+"\n" +
                    "                </td>\n" +
                    "                <td class=\"px-6 py-4\">\n" +
                    "                    "+exception.col+"\n" +
                    "                </td>\n"+
                    "</tr>\n";
        }

        body +="\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
        return body;

    }

    public void htmlReport(ArrayList<ExceptionReport> exceptions, String path) {
        ManageFile manageFile = new ManageFile();
        String content = htmlHeader() + cssStyles() + htmlBody(exceptions);
        manageFile.WriteFiles(path, content);

    }
}
