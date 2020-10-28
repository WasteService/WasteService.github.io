/**
 * Copyright 2008-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package buckley.compile;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RadioCheckField;

import java.io.IOException;


public class CheckboxFieldFactory implements ITextFieldFactory<RadioCheckField> {
    public RadioCheckField build(PdfWriter writer, Rectangle size, String name) {
        return new RadioCheckField(writer, size, name, "");
    }

    public PdfFormField buildFormField(RadioCheckField field) throws IOException, DocumentException {
        field.setCheckType(RadioCheckField.TYPE_CHECK);
        field.setChecked(false);
        return field.getCheckField();
    }
}