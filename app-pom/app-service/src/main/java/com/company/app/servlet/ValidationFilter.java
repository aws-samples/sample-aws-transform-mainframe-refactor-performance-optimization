package com.company.app.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * HTTP request filter.
 *
 * <p><b>This filter performs no validation.</b> It wraps each request in
 * {@link ValidatingHttpRequest}, which extends {@code HttpServletRequestWrapper}
 * and overrides nothing, so every request passes through unchanged. It is also
 * mapped only within this web application, while the batch job endpoints are
 * served by the separate {@code gapwalk_application} context, so those requests
 * never reach this filter.
 *
 * <p>Do not rely on it as a security control. See SECURITY.md in the repository
 * root for the gaps in this sample and what to use in production.
 */
public class ValidationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//NO-OP on purpose.
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new ValidatingHttpRequest((HttpServletRequest) request), response);
	}

	@Override
	public void destroy() {
		//NO-OP on purpose.
	}

}
