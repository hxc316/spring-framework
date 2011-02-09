/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.config;

import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.config.AbstractSpecificationBeanDefinitionParser;
import org.springframework.context.config.FeatureSpecification;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.w3c.dom.Element;

/**
 * {@link org.springframework.beans.factory.xml.BeanDefinitionParser} that parses a
 * {@code view-controller} element to register a {@link ParameterizableViewController}.
 *
 * @author Rossen Stoyanchev
 * @since 3.0
 * @see MvcViewControllers
 * @see MvcViewControllersExecutor
 */
class ViewControllerBeanDefinitionParser extends AbstractSpecificationBeanDefinitionParser {

	/**
	 * Parses the {@code <mvc:view-controller/>} tag.
	 */
	public FeatureSpecification doParse(Element element, ParserContext parserContext) {
		String path = element.getAttribute("path");
		String viewName = element.getAttribute("view-name");
		return new MvcViewControllers(path, viewName.isEmpty() ? null : viewName);
	}

}
