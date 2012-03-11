/**
 *  This file is part of Kowy Maker - Specification.
 *
 *  Kowy Maker - Specification is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Kowy Maker - Specification is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Kowy Maker - Specification.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.Message;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

/**
 * @author Koka El Kiwi
 * 
 */
public abstract class MessageCodec<T extends Message>
{
    protected final byte opcode;
    
    public MessageCodec(byte opcode)
    {
        this.opcode = opcode;
    }
    
    public byte getOpcode()
    {
        return opcode;
    }
    
    public abstract T decode(DataBuffer buf);
    
    public abstract void encode(DataBuffer buf, T msg);
}
