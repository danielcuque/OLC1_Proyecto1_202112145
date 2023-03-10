package com.daniel.model;

import com.daniel.controller.Errors.ExceptionReport;

import java.util.ArrayList;

public class ReportHTML {

    private String pathErrors = "src/reports/ERRORES_202112145/";
    private String cssStyles() {

        return """
                <style>
                html {
                  line-height: 1.15;
                  -webkit-text-size-adjust: 100%;
                 font-family: 'Inter', sans-serif; }
                .flex {
                  display: flex;
                }
                .flex-col {
                  flex-direction: column;
                }
                .my-10 {
                  margin-top: 2.5rem;
                  margin-bottom: 2.5rem;
                }
                .mx-2 {
                  margin-left: 0.5rem;
                  margin-right: 0.5rem;
                }
                .text-4xl {
                  font-size: 2.25rem;
                }
                .mb-5 {
                  margin-bottom: 1.25rem;
                }
                .text-center {
                  text-align: center;
                }
                .font-medium {
                  font-weight: 500;
                }
                .relative {
                  position: relative;
                }
                .overflow-x-auto {
                  overflow-x: auto;
                }
                .w-full {
                  width: 100%;
                }
                .text-sm {
                  font-size: 0.875rem;
                }
                .text-left {
                  text-align: left;
                }
                .text-gray-400 {
                  color: #cbd5e0;
                }
                .bg-black {
                  background-color: #000000;
                }
                .rounded-xl {
                  border-radius: 0.75rem;
                }
                .text-xs {
                  font-size: 0.75rem;
                }
                .text-gray-900 {
                  color: #1a202c;
                }
                .uppercase {
                  text-transform: uppercase;
                }
                .px-6 {
                  padding-left: 1.5rem;
                  padding-right: 1.5rem;
                }
                .py-3 {
                  padding-top: 0.75rem;
                  padding-bottom: 0.75rem;
                }
                .bg-white {
                  background-color: #ffffff;
                }
                .font-medium {
                  font-weight: 500;
                }
                .text-white {
                  color: #ffffff;
                }
                .whitespace-nowrap {
                  white-space: nowrap;
                }
                .px-6 {
                  padding-left: 1.5rem;
                  padding-right: 1.5rem;
                }
                .py-4 {
                  padding-top: 1rem;
                  padding-bottom: 1rem;
                }
                </style>
                """;
    }

    private String htmlHeader() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

                    <title>Tabla de errores</title>
                  </head>
                """;
    }

    private String htmlBody(ArrayList<ExceptionReport> exceptions) {
        StringBuilder body = new StringBuilder();
        body.append("""
                <div class="flex flex-col my-10 mx-2">
                <h1 class="text-4xl mb-5 text-center font-medium">Tabla de reportes</h1>
                <div class="relative overflow-x-auto">
                    <table class="w-full text-sm text-left text-gray-400 bg-black rounded-xl">
                        <thead class="text-xs uppercase text-gray-400">
                            <tr>
                                <th scope="col" class="px-6 py-3">
                                    #
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Tipo de error
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Descripción
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Línea
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Columna
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                """);
        int count = 0;
        for (ExceptionReport exception : exceptions) {
            body.append("""
                    <tr>
                                    <th scope="row" class="px-6 py-4 font-medium whitespace-nowrap text-white">
                                       \s""").append(count).append("\n").append("                </th>\n").append("<th scope=\"row\" class=\"px-6 py-4 font-medium whitespace-nowrap text-white\">\n").append("                    ").append(exception.type).append("\n").append("                </th>\n").append("                <td class=\"px-6 py-4\">\n").append("                    ").append(exception.description).append("\n").append("                </td>\n").append("                <td class=\"px-6 py-4\">\n").append("                    ").append(exception.line).append("\n").append("                </td>\n").append("                <td class=\"px-6 py-4\">\n").append("                    ").append(exception.col).append("\n").append("                </td>\n").append("</tr>\n");
            count++;
        }

        body.append("""

                        </tbody>
                    </table>
                </div>
                </div>
                </body>
                </html>
                """);
        return body.toString();

    }

    public void generateHTMLReport(ArrayList<ExceptionReport> exceptions, String name) {
        String content = htmlHeader() + cssStyles() + htmlBody(exceptions);

        ManageFile.WriteFiles(this.pathErrors + name + ".html", content);
    }
}
