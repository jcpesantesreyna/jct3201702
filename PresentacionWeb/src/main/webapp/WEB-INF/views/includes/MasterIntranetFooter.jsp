   <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                               Blog
                            </a>
                        </li>
                    </ul>
                </nav>
                <p class="copyright pull-right">
                    
                </p>
            </div>
        </footer>

    </div>
</div>


</body>
    <spring:url value="/resources/Boostrap/assets/js/jquery.3.2.1.min.js" var="jqueryJS"/>
    <spring:url value="/resources/Boostrap/assets/js/bootstrap.min.js" var="bootstrapJS"/>
    
    <spring:url value="/resources/Boostrap/assets/js/chartist.min.js" var="sbadminJS"/>
    <spring:url value="/resources/Boostrap/assets/js/bootstrap-notify.js" var="noti"/>
    <spring:url value="/resources/Boostrap/assets/js/light-bootstrap-dashboard.js?v=1.4.0" var="dashjs"/>
    <spring:url value="/resources/Boostrap/assets/js/demo.js" var="demojs"/>
    <script src="${jqueryJS}"></script>
    <script src="${bootstrapJS}"></script>
    
    <script src="${sbadminJS}"></script>
    <script src="${noti}"></script>
    <script src="${dashjs}"></script>
    <script src="${demojs}"></script>

</html>